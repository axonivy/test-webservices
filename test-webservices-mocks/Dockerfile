FROM openjdk:8

RUN groupadd -r -g 1000 soapui && useradd -r -u 1000 -g soapui -m -d /home/soapui soapui
RUN curl -kLO https://s3.amazonaws.com/downloads.eviware/soapuios/5.4.0/SoapUI-5.4.0-linux-bin.tar.gz && \
    echo "151ebe65215b19898e31ccbf5d5ad68b SoapUI-5.4.0-linux-bin.tar.gz" >> MD5SUM && \
    md5sum -c MD5SUM && \
    tar -xzf SoapUI-5.4.0-linux-bin.tar.gz -C /home/soapui && \
    rm -f SoapUI-5.4.0-linux-bin.tar.gz MD5SUM
RUN chown -R soapui:soapui /home/soapui
RUN find /home/soapui -type d -execdir chmod 770 {} \;
RUN find /home/soapui -type f -execdir chmod 660 {} \;

RUN apt-get update \
    && apt-get install -y --no-install-recommends \
        cron \
        gosu \
    && rm -rf /var/lib/apt/lists/*


USER soapui
ENV SOAPUI_DIR /home/soapui/SoapUI-5.4.0

USER root

COPY --chown=soapui:soapui docker-entrypoint.sh /
RUN chmod 700 /docker-entrypoint.sh
RUN chmod 770 $SOAPUI_DIR/bin/*.sh

ENTRYPOINT ["/docker-entrypoint.sh"]
CMD ["start-soapui"]

ADD webserviceXsunrise-soapui-project.xml /home/soapui/soapui-prj/
