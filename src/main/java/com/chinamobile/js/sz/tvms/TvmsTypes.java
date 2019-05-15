package com.chinamobile.js.sz.tvms;

public interface TvmsTypes {

    static final String LOGIN_USER = "_LOGIN_USER_VO";
    static final String LOGIN_USER_FUNC = "_LOGIN_USER_CURR_FUNC_ID";

    //{----------------- DATE PATTERN ------------------------
//    static final String DATE_PATTERN_INPUT = SystemUtil.getString("date.format.input", "yyyy-MM-dd");
//    static final String DATE_PATTERN_DISPLAY = SystemUtil.getString("date.format.display", "yyyy-MM-dd");
//    static final String DATETIME_PATTERN_INPUT = SystemUtil.getString("datetime.format.input", "yyyy-MM-dd HH:mm:ss");
//    static final String DATETIME_PATTERN_DISPLAY = SystemUtil.getString("datetime.format.display", "yyyy-MM-dd HH:mm:ss");

//    final String DATE_PATTERN_INPUT = systemUtil.getString("date.format.input","yyyy-MM-dd");
//    final String DATE_PATTERN_DISPLAY = systemUtil.getString("date.format.display", "yyyy-MM-dd");
//    final String DATETIME_PATTERN_INPUT = systemUtil.getString("datetime.format.input", "yyyy-MM-dd HH:mm:ss");
//    final String DATETIME_PATTERN_DISPLAY = systemUtil.getString("datetime.format.display", "yyyy-MM-dd HH:mm:ss");
    //}----------------- DATE PATTERN ------------------------

    //{----------------- ORG TYPE & DEFAULT WELCOME PAGE ------------------------
//    final String ORG_TYPE_LAST_LEVEL_STR = systemUtil.getProperty("org.type.market.num");
//    final String DISABLE_TYPE_ROLE_ID = systemUtil.getString("disable.role.id", "1,2,3");
//    final String DEFAULT_WELCOME_URI = systemUtil.getString("error.direct.url", "/welcome.do");
//    final String DEFAULT_RELOGIN_URI = systemUtil.getString("error.direct.reloginUrl", "/relogin.do");
//    final String DEFAULT_RELOGINALL_URI = systemUtil.getString("error.direct.reloginAllUrl", "/relogin.do");
//    final String DEFAULT_HOMEALL_URI = systemUtil.getString("error.direct.homeAllUrl", "/relogin.do");
//    final String BUSINIESS_ROLE_ID = systemUtil.getProperty("busibess.role.id");
    // }----------------- ORG TYPE & DEFAULT WELCOME PAGE ------------------------

    //{----------------- SYS FUNC ------------------------
    static final Long FUNC_TSKMGM = 1L;
    static final Long FUNC_SYSCFG = 2L;
    static final Long FUNC_PROCESS = 3L;
    static final Long FUNC_STOASS = 4L;
    static final Long FUNC_USEEXE = 5L;
    static final Long FUNC_REPORT = 6L;

    static final Long FUNC_TSKMGM_MYTASK = 101L;
    static final Long FUNC_TSKMGM_MY3RTASK = 102L;
    static final Long FUNC_TSKMGM_MYCANCElTASK = 103L;

    static final Long FUNC_SYSCFG_ROLE = 201L;
    static final Long FUNC_SYSCFG_OPERATOR = 202L;
    static final Long FUNC_SYSCFG_VCHRSTYLE = 203L;
    static final Long FUNC_SYSCFG_PLAN = 204L;
    static final Long FUNC_SYSCFG_TERMINAL = 205L;
    static final Long FUNC_SYSCFG_PROC_CONF = 206L;
    static final Long FUNC_SYSCFG_TERMINAL_SUPPLIER = 207L;
    static final Long FUNC_SYSCFG_PUBLISH_COMPANY = 208L;

    static final Long FUNC_REQAPR_MAKENEW = 301L;
    static final Long FUNC_REQAPR_FETCHNEW = 302L;
    static final Long FUNC_REQAPR_MAKEHIST = 303L;
    static final Long FUNC_REQAPR_FETCHHIST = 304L;

    static final Long FUNC_STOASS_STOIN = 401L;
    static final Long FUNC_STOASS_STOOUT = 402L;
    static final Long FUNC_STOASS_ASSNEW = 403L;
    static final Long FUNC_STOASS_BACKNEW = 404L;
    static final Long FUNC_STOASS_ASSHIST = 405L;
    static final Long FUNC_STOASS_REBHIST = 406L;

    static final Long FUNC_USEEXE_SENDNEW = 501L;
    static final Long FUNC_USEEXE_SENDNEWBAT = 502L;
    static final Long FUNC_USEEXE_USEMAKE = 503L;
    static final Long FUNC_USEEXE_HISTSEND = 504L;
    static final Long FUNC_USEEXE_HISTUSE = 505L;
    static final Long FUNC_USEEXE_MANAGEIMEI = 506L;
    static final Long FUNC_USEEXE_VCHRUSEDETAILS = 507L;

    static final Long FUNC_REPORT_BUSINESS = 601L;
    static final Long FUNC_REPORT_STORAGE = 602L;
    static final Long FUNC_REPORT_VCHR = 603L;
    static final Long FUNC_REPORT_EXPIRED = 604L;
    static final Long FUNC_REPORT_CITY = 605L;
    static final Long FUNC_REPORT_COST = new Long(606);
    static final Long FUNC_REPORT_ACCOUNT = new Long(607);
    static final Long FUNC_REPORT_DISCREPANCY = new Long(608);
    static final Long FUNC_REPORT_BUSINESS_ADDRESS = new Long(609);
    static final Long FUNC_REPORT_COUNTY_STORAGE = new Long(610);
    static final Long FUNC_REPORT_CITY_STORAGE = new Long(611);
    //}----------------- SYS FUNC ------------------------

    //{----------------- VCHR STATUS ------------------------
    static final Integer VCHR_STATUS_NOT_ACTIVED = new Integer(0);
    static final Integer VCHR_STATUS_NOT_FETCHED = new Integer(1);
    static final Integer VCHR_STATUS_NOT_SENT = new Integer(2);
    static final Integer VCHR_STATUS_NOT_USED = new Integer(3);
    static final Integer VCHR_STATUS_HAS_USED = new Integer(4);
    static final Integer VCHR_STATUS_IS_REBACK = new Integer(5);
    //}----------------- VCHR STATUS ------------------------

    //{----------------- ROLE STATUS ------------------------
    static final Integer ROLE_STATUS_NOT_ACTIVED = 0;
    static final Integer ROLE_STATUS_IS_ACTIVED = 1;
    //}----------------- ROLE STATUS ------------------------

    //}--------------- VCHR ASSGIN STATUS --------------------
    static final Integer VCHR_ASSIGN_STATUS_ASSIGNED = new Integer(1);
    static final Integer VCHR_ASSIGN_STATUS_REBACKED = new Integer(2);
    static final Integer VCHR_ASSIGN_STATUS_ACCEPTED = new Integer(3);
    static final Integer VCHR_ASSIGN_STATUS_CANCELED = new Integer(4);
    static final Integer VCHR_ASSIGN_ISREVERSE_TRUE = new Integer(1);
    static final Integer VCHR_ASSIGN_ISREVERSE_FALSE = new Integer(0);
    //}--------------- VCHR ASSGIN STATUS --------------------

    //{----------------- VCHR SEND ERROR CODE ------------------------
    static final Integer VCHR_SEND_NOT_FOUND = new Integer(5);
    static final Integer VCHR_SEND_EXPIRED = new Integer(6);
    static final Integer VCHR_ORG_IS_NOT_EFFECT = new Integer(-1);
    static final Integer VCHR_NOT_AT_ORG = new Integer(10);
    static final Integer VCHR_NOT_BANDING_PLAN = new Integer(-2);
    static final Integer VCHR_NOT_STUDENT = new Integer(-3);
    static final Integer VCHR_NO_STYLEID = new Integer(-4);
    static final Integer VCHR_NOCHECK_STUDENTVCHR = new Integer(-5);

    //{----------------- VCHR SEND OR USE ------------------------
    static final Integer VCHR_OPERATE_SEND = new Integer(1);
    static final Integer VCHR_OPERATE_USE = new Integer(0);
    static final Integer VCHR_SEND_SUCCESS = new Integer(1);
    static final Integer VCHR_SEND_CANCEL = new Integer(0);
    static final Integer VCHR_USE_SUCCESS = 1;
    static final Integer VCHR_USE_CANCEL = 0;
//    final int LOCK_TIME = systemUtil.getInt("vchr.send.customNo.lock.time", 24);
//    final String PERMIT_PLANID = systemUtil.getString("vchr.send.permit.planId.when.it.is.not.studentVchr", "10");

    //{----------------- VCHR SEND ERROR CODE ------------------------

    //{----------------- PROCESS/TASK  ------------------------
    static final Long PROC_DEF_MAKE_REQUEST = new Long(1);
    static final Long PROC_DEF_FETCH_REQUEST = new Long(2);

    static final Long PROC_STATUS_OPEN = new Long(1);       //δ����
    static final Long PROC_STATUS_REJECTED = new Long(2);   //���˻�
    static final Long PROC_STATUS_RETRIEVED = new Long(3);  //���ջ�
    static final Long PROC_STATUS_DELETED = new Long(4);    //��ɾ��
    static final Long PROC_STATUS_CLOSED = new Long(5);     //�ѽ���
    static final Long PROC_STATUS_PROCESSING = new Long(6); //������

    static final Long TASK_STATUS_OPEN = new Long(1);
    static final Long TASK_STATUS_CLOSED = new Long(2);

    static final Long MYTASK_TYPE_REQ_APPROVE = new Long(1);
    static final Long MYTASK_TYPE_REQ_CANCEL = new Long(2);
    static final Long MYTASK_TYPE_ASS_ACCEPT = new Long(3);
    static final Long MYTASK_TYPE_ASS_CANCEL = new Long(4);
    //}----------------- PROCESS/TASK  ------------------------

    //{----------------- REGION ------------------------
    static final Long REGION_JS = new Long(10);
    static final Long REGION_SZ = new Long(11);
    //}----------------- REGION ------------------------

    //{----------------- CITY ------------------------
    static final Long CITY_SZ = new Long(11);
    static final Long CITY_SZ_SUZHOU = new Long(1101);
    static final Long CITY_SZ_KUNSHAN = new Long(1103);
    static final Long CITY_SZ_ZHANGJIAGANG = new Long(1104);
    static final Long CITY_SZ_WUJIANG = new Long(1105);
    static final Long CITY_SZ_CHANGSHU = new Long(1106);
    static final Long CITY_SZ_TAICANG = new Long(1107);
    //}----------------- CITY ------------------------

    //{----------------- ORG ------------------------
    static final Long ORG_SZ_SUZHOU = new Long(11100001);
    static final Long ORG_SZ_KUNSHAN = new Long(11100002);
    static final Long ORG_SZ_ZHANGJIAGANG = new Long(11100003);
    static final Long ORG_SZ_WUJIANG = new Long(11100004);
    static final Long ORG_SZ_CHANGSHU = new Long(11100005);
    static final Long ORG_SZ_TAICANG = new Long(11100006);
    //}----------------- ORG ------------------------

    //{------------------- IS DELETE ------------------
    static final Long IS_DELETE = new Long(1);
    static final Long NOT_DELETE = new Long(0);
    // }-------------------IS DELETE-------------------

    //{------------------- IS SYN ----------------------
    static final Integer IS_SYN = new Integer(1);
    static final Integer NOT_SYN = new Integer(0);
    //}------------------- IS SYN --------------------

    //{-------------------IS_ACTIVE -----------------------
    static final Integer IS_ACTIVE = new Integer(1);
    static final Integer NOT_ACTIVE = new Integer(0);
    // -------------------IS_ACTIVE ------------------------}

    //{-------------------- CHANNEL----------------------------
    static final String CH_ENTITY = "CHANNEL_ENTITY";
    static final String CH_VIRTUAL = "CHANNEL_VIRTUAL";
    static final String CH_ENTITY_SELF = "CHANNEL_ENTITY_SELF";
    static final String CH_ENTITY_SPEC = "CHANNEL_ENTITY_SPEC";
    static final String CH_VIRTUALS = "CHANNEL_VIRTUALS";
    static final Integer ENTITY_CHANNEL = new Integer(0);
    //}-------------------- CHANNEL----------------------------

    static final Integer IMEI_STATUS_ONSALE = new Integer(1);
    static final Integer IMEI_STATUS_EXCHANGED = new Integer(4);

    static final String CODE_SMS_TEMPLATE = "SMS_TEMPLATE";
}
