package com.huang.pims.mybatis.typehandlers;

import com.huang.pims.enums.base.SexEnum;
import org.apache.ibatis.type.*;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author huang
 */
@MappedTypes(SexEnum.class)
@MappedJdbcTypes(JdbcType.INTEGER)
public class SexEnumTypeHandler implements TypeHandler<SexEnum> {

    @Override
    public void setParameter(PreparedStatement ps, int i, SexEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getCode());
    }

    @Override
    public SexEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
        return SexEnum.getByCode(rs.getInt(columnIndex));
    }

    @Override
    public SexEnum getResult(ResultSet rs, String columnName) throws SQLException {
        return SexEnum.getByCode(rs.getInt(columnName));
    }

    @Override
    public SexEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return SexEnum.getByCode(cs.getInt(columnIndex));
    }
}
