/**
 * Created by mcs on 2016/11/10.
 */
var vue = new Vue({
    el: "#main",
    data: {
        user: user,
        riskList: riskList,
        causes: [],
        controls:[],
        allCauses: [],
        curRisk: '',
        isCheck:false
    },
    mounted: function () {
        this.$http.post('/riskmanager/risk/getAllCauses', {emulateJSON: true}).then(function (response) {
            this.allCauses = response.data.causes;
        });
        this.$http.post('/riskmanager/risk/getAllControls', {emulateJSON: true}).then(function (response) {
            this.controls = response.data.controls;
        });
    },
    methods: {
        showRisk: function (risk) {
            if(!this.isCheck){
                this.curRisk = risk;
                this.$http.post('/riskmanager/risk/getCauses', {id: risk.id}, {emulateJSON: true}).then(function (response) {
                    this.causes = response.data.causes;
                    if (user.id == risk.submitter_id) {
                        $(".info").removeAttr("disabled");
                    } else if (user.role == 2){
                        $(".info").remove("disabled");
                    }else {
                        $(".info").attr("disabled", "disabled");
                    }
                    $("#dialog").dialog("open");
                });
            }
        },
        addRisk: function () {
            $(".info").removeAttr("disabled");
            this.curRisk = {
                title: '',
                description: '',
                level: '',
                possibility: '',
                state: 0,
                submitter_id: '',
                controlId: '',
                threshold: ''
            };
            this.causes = [];
            $("#dialog").dialog("open");
        },
        formatData:function (time) {
            var date=new Date(time);
            var result=date.getFullYear()+"/"+((date.getMonth()+1)>9?(date.getMonth()+1):("0"+(date.getMonth()+1)))+"/"+(date.getDate()>9?date.getDate():("0"+date.getDate()))+" "+
                (date.getHours()>9?date.getHours():("0"+date.getHours()))+
            ":"+(date.getMinutes()>9?date.getMinutes():("0"+date.getMinutes()))+":"+(date.getSeconds()>9?date.getSeconds():("0"+date.getSeconds()));
            return result;
        },
        check:function (risk) {
            this.isCheck=true;
            this.$http.post('/riskmanager/risk/check', {id: risk.id}, {emulateJSON: true}).then(function (response) {
                this.riskList[this.riskList.indexOf(risk)].state=1;
                this.isCheck=false;
            });
        },
        shouldShowCheck:function (risk) {
            for(var i=0;i<this.controls.length;i++){
                if(risk.controlId==this.controls[i].controlId){
                    if(this.controls[i].ownerId=user.id){
                        return true;
                    }
                }
            }
            return false;
        },
        getControlPoint:function (controlId) {
            for(var i=0;i<this.controls.length;i++){
                if(controlId==this.controls[i].controlId){
                    return this.controls[i].control_point;
                }
            }
        }
    }
});

$("#dialog").dialog({
    autoOpen: false,
    resizable: false,
    height: 800,
    width: 500,
    modal: true,
    buttons: {
        "确定": function () {
            vue.curRisk['submitter_id'] = user.id;
            vue.$http.post('/riskmanager/risk/modify', vue.curRisk, {emulateJSON: true}).then(function (response) {
                for (var i = 0; i < vue.causes.length; i++) {
                    vue.$http.post('/riskmanager/risk/addCause', {
                        riskId: response.data.riskId,
                        cause: vue.causes[i]
                    }, {emulateJSON: true}).then(function (res) {
                        $("#dialog").dialog("close");
                        vue.causes = [];
                        window.location.reload();
                    });
                }
            });
        },
        "取消": function () {
            $(this).dialog("close");
        }
    }
});