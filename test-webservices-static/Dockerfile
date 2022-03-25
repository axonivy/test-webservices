FROM httpd:2.4

# https
COPY ./certs/ /usr/local/apache2/conf/
RUN sed -i \
        -e 's/^#\(Include .*httpd-ssl.conf\)/\1/' \
        -e 's/^#\(LoadModule .*mod_ssl.so\)/\1/' \
        -e 's/^#\(LoadModule .*mod_socache_shmcb.so\)/\1/' \
        conf/httpd.conf

# static
COPY ./web/ /usr/local/apache2/htdocs/
