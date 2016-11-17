node{
stage('SCM') {
git 'https://github.com/liujiamiao/homework.git'
}
stage('QA') {
 sh 'sonar-scanner'
}
 stage('build') {
  def mvnHome = tool 'M3'
   sh "${mvnHome}/bin/mvn -B clean package"
 }
  stage('deploy') {
   sh "sudo docker stop my || true"
    sh "sudo docker rm my || true"
     sh "sudo docker run --name tomcatweb -p 10086:8080 -d tomcat:8.0"
     sh "sudo docker cp target/riskmanager-1.0-SNAPSHOT.war tomcatweb:/usr/local/tomcat/webapps/RiskManager.war"
  }
   stage('results') {
 archiveArtifacts artifacts: '**/target/*.war', fingerprint: true
   }

}