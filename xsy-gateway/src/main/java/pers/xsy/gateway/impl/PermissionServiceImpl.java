package pers.xsy.gateway.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 请求权限判断service
 *
 * @author xsy
 *
 */
@Slf4j
@Service("permissionService")
public class PermissionServiceImpl {
   // @Resource
   // private MenuService menuService;

   /* @Override
    public List<SysMenu> findMenuByRoleCodes(String roleCodes) {
        return menuService.findByRoleCodes(roleCodes);
    }*/

    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        return true;
    }
}
