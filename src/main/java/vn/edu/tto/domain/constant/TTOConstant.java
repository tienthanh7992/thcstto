package vn.edu.tto.domain.constant;

public class TTOConstant {

    public final class CHEStatus {
        public static final String PENDING = "PENDING";
        public static final String LEADER_APPROVED = "LEADER_APPROVED";
        public static final String PRINCIPAL_APPROVED = "PRINCIPAL_APPROVED";
    }
    
    public final class RoleType {
        public static final String PRINCIPAL = "PRINCIPAL";
        public static final String VICE_PRINCIPAL = "VICE_PRINCIPAL";
        public static final String TEACHER = "TEACHER";
        public static final String EMPLOYEE = "EMPLOYEE";
        public static final String DIRECTOR = "DIRECTOR";
    }
    
    public static final int PAGE_SIZE = 20;
}
