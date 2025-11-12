package org.chandra.springdatajpamusclememory.topic3_customqueries.task7;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount,Long> {

    @Modifying
    @Transactional
    @Query("UPDATE UserAccount u SET u.role = :newRole WHERE u.userName = :username")
    int updateUserRoleByUsername(String username, String newRole);

    @Modifying
    @Transactional
    @Query("UPDATE UserAccount u SET u.active = false WHERE u.role = :userRole")
    int updateUserActiveByUserRole(String userRole);

    @Modifying
    @Transactional
    @Query("DELETE FROM UserAccount u WHERE u.active = false ")
    int deleteInactiveUsers();

}
