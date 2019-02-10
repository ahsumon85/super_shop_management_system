package com.super_shop.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.super_shop.dto.LoginDTO;
import com.super_shop.dto.ManagerInfoDTO;
import com.super_shop.entity.Login;
import com.super_shop.entity.ManagerInfo;
import com.super_shop.repo.LoginRepo;
import com.super_shop.repo.ManagerRepo;

@Service
@Transactional
public class LoginService {

	@Autowired
	private LoginRepo loginRepo;

	@Autowired
	private ManagerRepo managerRepo;

	public Login findUserInfo(String userName) {
		return loginRepo.findByUserName(userName);
	}

	public Boolean saveSignUp(ManagerInfoDTO managerInfoDTO) {
		Boolean status= false;
		String activeCode = "suPer10SHoP";
		if (managerInfoDTO.getActivation().equals(activeCode)) {
			managerRepo.save(managerDtoToEntity(managerInfoDTO));
			ManagerInfo managerInfo = new ManagerInfo();
			managerInfo = managerRepo.findByManagerId(managerInfoDTO.getManagerId());

			LoginDTO loginDTO = new LoginDTO();
			Login login = new Login();
			loginDTO.setManagerInfo(managerInfo);
			loginDTO.setUserName(managerInfoDTO.getUserName());
			loginDTO.setPassword(managerInfoDTO.getPassword());
			loginDTO.setRole(2);
			BeanUtils.copyProperties(loginDTO, login);
			loginRepo.save(login);
			status=true;
		}
		return status;

	}

	public List<LoginDTO> findAllLogin() {
		return loginRepo.findAll().stream().map(login -> copyDtoToEntity(login)).collect(Collectors.toList());

	}

	public ManagerInfo managerDtoToEntity(ManagerInfoDTO managerInfoDTO) {
		ManagerInfo managerInfo = new ManagerInfo();
		managerInfoDTO.setCreateDate(new Date());
		BeanUtils.copyProperties(managerInfoDTO, managerInfo);
		return managerInfo;
	}

	public LoginDTO copyDtoToEntity(Login login) {
		LoginDTO loginDTO = new LoginDTO();
		BeanUtils.copyProperties(login, loginDTO);
		return loginDTO;
	}

	public LoginDTO loginEntityToDto(Login login) {
		LoginDTO loginDTO = new LoginDTO();
		BeanUtils.copyProperties(login, loginDTO);
		return loginDTO;
	}

}
