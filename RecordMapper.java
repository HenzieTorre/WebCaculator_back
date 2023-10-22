package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.Record;
import pojo.RecordExample;
public interface RecordMapper {
    long countByExample(RecordExample example);

    int deleteByExample(RecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Record row);

    int insertSelective(Record row);

    List<Record> selectByExample(RecordExample example);

    Record selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") Record row, @Param("example") RecordExample example);

    int updateByExample(@Param("row") Record row, @Param("example") RecordExample example);

    int updateByPrimaryKeySelective(Record row);

    int updateByPrimaryKey(Record row);

    List<Record> selectLast10();

    int deleteAll();

    Record getLast();
}
