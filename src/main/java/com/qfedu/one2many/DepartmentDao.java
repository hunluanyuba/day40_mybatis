package com.qfedu.one2many;

public interface DepartmentDao {
    Department findByDid(int eid);
    Department findByDid_new(int eid);
    Department findByDeptId(int did);
}
