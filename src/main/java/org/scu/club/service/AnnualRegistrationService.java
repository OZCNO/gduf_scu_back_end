package org.scu.club.service;

import java.util.List;
import org.scu.base.service.BaseDBService;
import org.scu.club.entity.AnnualRegistration;
import org.scu.club.vo.QAnnualRegistration;
import org.scu.club.vo.VAnnualRegistration;

/**
 * Created by lamm on 2019/1/26
 */
public interface AnnualRegistrationService extends BaseDBService<QAnnualRegistration, AnnualRegistration> {

  List<VAnnualRegistration> listDetail(QAnnualRegistration search);
}
