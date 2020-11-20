package org.fivesoft.appgrant.test.service;

import org.fivesoft.common.annotion.Permission;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Permission
    public boolean testPermit(){
        return true;
    }
}
