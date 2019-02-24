package org.scu.club.mapper;

import java.util.List;
import org.scu.base.mapper.BaseMapper;
import org.scu.club.entity.AnnualRegistration;
import org.scu.club.vo.QAnnualRegistration;
import org.scu.club.vo.VAnnualRegistration;

/**
 * Created by lynn on 2019/1/26
 */
public interface AnnualRegistrationMapper extends BaseMapper<QAnnualRegistration, AnnualRegistration> {

  List<VAnnualRegistration> listDetail(QAnnualRegistration search);
}
