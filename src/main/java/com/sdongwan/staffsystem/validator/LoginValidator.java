package com.sdongwan.staffsystem.validator;

import com.sdongwan.staffsystem.entity.Admin;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Administrator on 2017/7/1.
 */
//使用自定义的validator进行表单验证操作，这个项目还用到另一种表单验证，也就是使用JSR进行验证
public class LoginValidator implements Validator {
    public boolean supports(Class<?> aClass) {
        return Admin.class.isAssignableFrom(aClass);
    }

    public void validate(Object o, Errors errors) {
        Admin admin = (Admin) o;
//        ValidationUtils.rejectIfEmpty(errors, "adminName", "adminName.requird");
        ValidationUtils.rejectIfEmpty(errors, "adminUserName", "adminUserName.requird");
        ValidationUtils.rejectIfEmpty(errors, "adminPwd", "adminPwd.requird");
    }
}
