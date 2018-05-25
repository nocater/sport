package sport.service.result.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sport.bean.Result_;
import sport.dao.Result_Mapper;
import sport.service.result.Result_Service;
@Service
public class Result_Impl implements Result_Service{
    @Autowired
    Result_Mapper result_mapper;
	@Override
	public List<Result_> getResult_byClas_id(Integer id) {
		// TODO Auto-generated method stub
		
		
	  List<Result_> results_ = result_mapper.selectByClassId(id);
		
		
		return results_;
	}
	@Override
	public List<Result_> getResult_byStudent_id(Integer id) {
		// TODO Auto-generated method stub
		List<Result_> results_ = result_mapper.selectByStudentId(id);
		
		return results_;
	}

}
