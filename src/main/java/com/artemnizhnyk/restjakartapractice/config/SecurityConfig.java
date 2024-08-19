package com.artemnizhnyk.restjakartapractice.config;

import jakarta.annotation.security.DeclareRoles;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

@DeclareRoles({"USER", "ADMIN"})
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "java:app/jdbc/appDataSource",
        callerQuery = "select password from users where USERNAME = ?",
        groupsQuery = "select g.GROUP_NAME from USER_GROUPS ug, users u, "
                        + "GROUPS g where ug.USER_ID = u.user_id and "
                        + "g.GROUP_ID= ug.GROUP_ID and u.USERNAME=?"
)
@ApplicationScoped
public class SecurityConfig {
}