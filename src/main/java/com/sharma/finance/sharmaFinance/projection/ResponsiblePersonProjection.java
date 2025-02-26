package com.sharma.finance.sharmaFinance.projection;

import java.time.LocalDateTime;
import java.util.List;
import java.util.*;

public interface ResponsiblePersonProjection {
    Long getResponsibleId();
    String getName();
    String getContactInfo();
    LocalDateTime getCreatedOn();
    LocalDateTime getUpdatedOn();
    List<MemberProjection> getMembers();
}