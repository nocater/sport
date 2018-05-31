package sport.service.env.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sport.bean.Class_;
import sport.bean.Env;
import sport.bean.Item;
import sport.dao.EnvMapper;
import sport.dao.ItemMapper;
import sport.service.env.EnvService;
@Service
public class EnvServiceImpl implements EnvService {
    @Autowired
    private EnvMapper envmapper;
    @Autowired
    private ItemMapper itemMapper;
	@Override
	public List<Env> getAllByClassId(Integer id) {
		// TODO Auto-generated method stub
		List<Env> selectEnvByClassId = envmapper.selectEnvByClassId(id);
		return selectEnvByClassId;
	}
	@Override
	public int deleteByClas(Integer clas_id) {
		// TODO Auto-generated method stub
		return envmapper.deleteByClas_id(clas_id);
	}
	@Override
	public int insertByClas(List<Integer> item_ids, Class_ clas) {
		// TODO Auto-generated method stub
		for(Integer item_id : item_ids){
			Item item = itemMapper.selectByPrimaryKey(item_id);
			Env env = new Env();
			env.setItem(item);
			env.setClass_(clas);
			env.setName("项目_"+item.getId()+item.getName());
			envmapper.insert(env);
		}
		return item_ids.size();
	}
}
