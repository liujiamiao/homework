/**
 * Created by mcs on 2016/11/10.
 */
var vue = new Vue({
    el: "#main",
    data: {
        user: user,
        riskList: riskList,
        causes: [],
        allCauses: [],
        curRisk: ''
    },
    mounted: function () {
        this.$http.post('/risk/getAllCauses', {emulateJSON: true}).then(function (response) {
            this.allCauses = response.data.causes;
        });
    },
    methods: {
        showRisk: function (risk) {
            this.curRisk = risk;
            this.$http.post('/risk/getCauses', {id: risk.id}, {emulateJSON: true}).then(function (response) {
                this.causes = response.data.causes;
                if (user.id == risk.submitter_id) {
                    $(".info").removeAttr("disabled");
                } else {
                    $(".info").attr("disabled", "disabled");
                }
                $("#dialog").dialog("open");
            });
        },
        addRisk: function () {
            $(".info").removeAttr("disabled");
            this.curRisk = {
                title: '',
                description: '',
                level: '',
                possibility: '',
                state: '',
                submitter_id: '',
                tracker_id: '',
                threshold: ''
            };
            this.causes = [];
            $("#dialog").dialog("open");
        },
        formatData:function (time) {
            console.log(time);
            var date=new Date(time);
            console.log(date);
            var result=date.getFullYear()+"/"+((date.getMonth()+1)>9?(date.getMonth()+1):("0"+(date.getMonth()+1)))+"/"+(date.getDate()>9?date.getDate():("0"+date.getDate()))+" "+
                (date.getHours()>9?date.getHours():("0"+date.getHours()))+
            ":"+(date.getMinutes()>9?date.getMinutes():("0"+date.getMinutes()))+":"+(date.getSeconds()>9?date.getSeconds():("0"+date.getSeconds()));
            console.log(result);
            return result;
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
            vue.$http.post('/risk/modify', vue.curRisk, {emulateJSON: true}).then(function (response) {
                for (var i = 0; i < vue.causes.length; i++) {
                    vue.$http.post('/risk/addCause', {
                        riskId: vue.curRisk.id,
                        cause: vue.causes[i]
                    }, {emulateJSON: true});
                }
                $("#dialog").dialog("close");
                vue.causes = [];
                window.location.reload();
            });
        },
        "取消": function () {
            $(this).dialog("close");
        }
    }
});