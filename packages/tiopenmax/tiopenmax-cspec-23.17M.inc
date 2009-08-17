CCASE_SPEC = "\
${@base_contains("DISTRO_FEATURES", "testpatterns", "", "element patterns /main/0", d)}%\
# OMX Audio%\
element /vobs/wtbu/OMAPSW_MPU/linux/audio/... LINUX_RLS_DB20091020%\
# OMX Video%\
element /vobs/wtbu/OMAPSW_MPU/linux/video/... LINUX_RLS_DB20091020%\
# OMX Image%\
element /vobs/wtbu/OMAPSW_MPU/linux/image/... LINUX_RLS_DB20091020%\
# LCML & core%\
element /vobs/wtbu/OMAPSW_MPU/linux/system/... LINUX_RLS_DB20091020%\
# OMX Application%\
element /vobs/wtbu/OMAPSW_MPU/linux/application/... LINUX_RLS_DB20091020%\
# OMX INST2 utilities%\
element /vobs/wtbu/OMAPSW_MPU/linux/utilities/src/inst2/... LINUX_RLS_DB20091020%\
# ROOT folder & Make files%\
element /vobs/wtbu/OMAPSW_MPU/linux/... LINUX_RLS_DB20091020%\
# MM ISP%\
element /vobs/wtbu/OMAPSW_MPU/... LINUX_RLS_DB20091020%\
# special hack needed because root of vob is not labeled:%\
element * /main/LATEST"