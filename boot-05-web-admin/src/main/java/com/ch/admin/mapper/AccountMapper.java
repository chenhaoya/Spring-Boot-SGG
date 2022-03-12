package com.ch.admin.mapper;

import com.ch.admin.bean.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface AccountMapper {

    Account getAccount(Long id);
}
