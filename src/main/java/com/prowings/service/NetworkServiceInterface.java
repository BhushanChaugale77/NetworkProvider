package com.prowings.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.prowings.dto.NetworkDto;
import com.prowings.entity.Network;

public interface NetworkServiceInterface {

	
	List<Network> getAllNetwork();
	
	Network networkById(Integer id);
	
	NetworkDto createNetwork(NetworkDto networkDto);
	
	void deleteNetworkById(Integer id);
	
	NetworkDto updateNetworkById(Integer id, NetworkDto networkDto);
	
	NetworkDto patchNetworkById(Integer id, NetworkDto networkDto);
	
	Page<Network> paginationNetwork(int page, int size);
	
}
