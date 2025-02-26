package com.sharma.finance.sharmaFinance.projection;

import java.time.LocalDateTime;

public interface MemberProjection {
    Long getMemberId();
    String getName();
    String getContactInfo();
    String getStatus();
    LocalDateTime getCreatedOn();
    LocalDateTime getUpdatedOn();
}

