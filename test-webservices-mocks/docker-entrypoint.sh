#!/bin/bash
export PROJECT=/home/soapui/soapui-prj/webserviceXsunrise-soapui-project.xml
export PATH=$SOAPUI_DIR/bin:$PATH

cd $SOAPUI_PRJ

# create a private pipe to simulate SoapUI's "Press any key to exit"
PIPE=$(mktemp -u)
mkfifo $PIPE
exec 3<>$PIPE
rm $PIPE

function stopSoapUi {
    echo "Stopping $MOCK_SERVICE_NAME..."
    echo "Stop" >&3
}

trap stopSoapUi TERM INT

if [ "$1" = 'start-soapui' ]; then

    echo "Starting mocks from SoapUI-project=$PROJECT"
    gosu soapui mockservicerunner.sh -Djava.awt.headless=true -Dfile.encoding=UTF8 $PROJECT <&3 &    

else
    gosu soapui "$@" <&3 &
fi

# wait for mocksevicerunner to exit
PID=$!
wait $PID
# prevent another trap while mocksevicerunner is stopping
trap - TERM INT
# wait for stop to complete
wait $PID
