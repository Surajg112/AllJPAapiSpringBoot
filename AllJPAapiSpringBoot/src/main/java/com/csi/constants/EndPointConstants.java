package com.csi.constants;

public class EndPointConstants {

    public static final String SIGN_UP = "/signup";

    public static final String SIGN_IN= "/signin/{empEmailId}/{empPassword}";

    public static final String SAVE_BULK_OF_DATA = "/savebulkofdata";

    public static final String GET_DATA_BY_ID = "/getdatabyid/{empId}";

    public static final String GET_DATA_BY_EMAIL_ID = "/getdatabyemaildid/{empEmailId}";

    public static final String GET_ALL_DATA = "/getalldata";

    public static final String GET_DATA_BY_NAME = "/getdatabyname/{empName}";

    public static final String GET_DATA_BY_CONTACT_NUMBER = "/getdatabycontactnumber/{empContactNumber}";

    public static final String GET_DATA_BY_DOB = "/getdatabydob/{empDOB}";

    public static final String GET_DATA_BY_ANY_INPUT = "/getdatabyanyinput/{input}";

    public static final String SORT_BY_ID = "/sortbyid";

    public static final String SORT_BY_NAME = "/sortbyname";

    public static final String SORT_BY_SALARY = "/sortbysalary";

    public static final String SORT_BY_DOB = "/sortbydob";

    public static final String FILTER_DATA_BY_SALARY = "/filterdatabysalary/{empSalary}";

    public static final String CHECK_LOAN_ELIGIBILTY = "/checkloanelgibility/{empId}";

    public static final String UPDATE_DATA_BY_ID = "/updatedatabyid/{empId}";

    public static final String DELETE_DATA_BY_ID = "/deletedatabyid/{empId}";

    public static final String DELETE_ALL_DATA = "/deletealldata";


}
