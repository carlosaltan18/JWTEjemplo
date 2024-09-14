package org.grupouno.Parqueo_Is4Tech.service;

import java.util.List;

public interface IRoleService {

     List<String> getRolesByProfileId(Long profileId);
}
