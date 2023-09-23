package com.example.deokjideokji.auth.infrastructure;

import com.example.deokjideokji.auth.domain.Authentication;
import com.example.deokjideokji.auth.domain.UserDetail;
import com.example.deokjideokji.auth.domain.vo.RoleType;
import org.springframework.stereotype.Component;

@Component
public class LocalContextHolder {
    private static final ThreadLocal<Authentication> context = new ThreadLocal<>();

    public static Authentication getContext (){
        if(context.get() == null) {
            setContext(new Authentication
                    (new UserDetail(), RoleType.GUEST));
        }
        return context.get();
    }
    public static void setContext(Authentication authentication){
        context.set(authentication);
    }

    public static void remove(){
        context.remove();
    }
}