# MTOM/Binary
The `zhr_wsif_axonivy_BL_ZZ_mtom.wsdl` is almost the same WSDL as the `zhr_wsif_axonivy_BL_ZZ.wsdl`.
The only difference is that the type `type="xsd:base64Binary"` has been extended with `xmime:expectedContentTypes="application/octet-stream"` as described here:

http://cxf.apache.org/docs/mtom-attachments-with-jaxb.html