package com.takeon.burette.user.repository;

import com.takeon.burette.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // 타입이 다른데도 체크가 없다니 심각하군
//     @Query("SELECT u FROM User u WHERE u.userId = :userId AND u.password = :password")
    // 네이티브에서는 snake_case로 직접 변경.. 두 타입 다 외워야 할 거면 굳이 왜 하지..?
    @Query(value = "SELECT * FROM User u WHERE u.user_id = :userId and u.password = :password LIMIT 1",
            nativeQuery = true)
    User getUserByUserIdAndPassword(@Param("userId") String userId, @Param("password") String password);

    @Query("SELECT u.writePermission FROM User u WHERE u.userId = :userId")
    int getWritePermissionByUserId(@Param("userId") String userId);

    @Query("SELECT u FROM User u WHERE u.userId = :userId")
    User getUserByUserId(@Param("userId") String userId);
}
