package com.prowings.serviceimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.prowings.dto.NetworkDto;
import com.prowings.entity.Network;
import com.prowings.repository.NetworkRepository;
import com.prowings.service.NetworkServiceInterface;

@Service
public class NetworkServiceImpl implements NetworkServiceInterface {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private NetworkRepository repository;
	@Override
	public List<Network> getAllNetwork() {
 		return repository.findAll();
	}
	@Override
	public Network networkById(Integer id) {
 		return repository.findById(id).orElseThrow();
	}
	@Override
	public NetworkDto createNetwork(NetworkDto networkDto) {
		Network network = mapper.map(networkDto, Network.class);
		repository.save(network);
		NetworkDto dto = mapper.map(network, NetworkDto.class);
		return dto;
	}
	@Override
	public void deleteNetworkById(Integer id) {
 		repository.deleteById(id);
	}
	@Override
	public NetworkDto updateNetworkById(Integer id, NetworkDto networkDto) {
		Network network = mapper.map(networkDto, Network.class);
		Network dto = new Network();
		
		dto.setId(networkDto.getId());
		dto.setNetworkPlans(networkDto.getNetworkPlans());
		dto.setNetworkProviderName(networkDto.getNetworkProviderName());
		dto.setProviderEmail(networkDto.getProviderEmail());
		dto.setProviderWebsite(networkDto.getProviderWebsite());
		
		repository.save(dto);
		NetworkDto dto2 = mapper.map(dto, NetworkDto.class);
		return dto2;
	}
	@Override
	public NetworkDto patchNetworkById(Integer id, NetworkDto networkDto) {
 
		Network network = mapper.map(networkDto, Network.class);
		Network dto = new Network();
		dto.setNetworkPlans(networkDto.getNetworkPlans());
		dto.setId(networkDto.getId());
		repository.save(dto);
		NetworkDto dto2 = mapper.map(dto, NetworkDto.class);
		return dto2;
	}
	@Override
	public Page<Network> paginationNetwork(int page, int size) {

		PageRequest pageRequest = PageRequest.of(page, size);
		return repository.findAll(pageRequest);
	}

	
}
