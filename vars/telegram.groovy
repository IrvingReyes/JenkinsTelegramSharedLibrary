#!/usr/bin/env groovy

def call(String mensaje = '', String SecretoToken = 'human', String SecretoChatID = '' ) {
  withCredentials([string(credentialsId: SecretoToken, variable: 'TOKEN'),string(credentialsId: SecretoChatID, variable: 'CHATID') ]) {
            sh """
            curl -v -X POST --silent --output /dev/null https://api.telegram.org/bot$TOKEN/sendMessage -d chat_id=$CHATID -d text='${mensaje}'
            """
            } 
}
