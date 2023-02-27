package com.project.rest.utils;
import java.util.stream.Collectors;

import com.project.model.ElementsDto;
import com.project.model.MetadataDto;
import com.project.model.PageDto;

import org.springframework.data.domain.Page;


//import com.project.api;
public class PageUtils {

	private static void fillPageDto(PageDto pageDto, Page<?> page)
	{
		pageDto.setEmpty(page.isEmpty());
		pageDto.setFirst(page.isFirst());
		pageDto.setLast(page.isLast());
		pageDto.setPage(page.getNumber());
		pageDto.setPaged(page.getPageable().isPaged());
		pageDto.setTotalPages(page.getTotalPages());
	}
	
	private static void fillElementsDto(ElementsDto elementsDto, Page<?> page)
	{
		elementsDto.setNumberElements(page.getNumberOfElements());
		elementsDto.setSize(page.getSize());
		elementsDto.setTotalElements(page.getTotalElements());
	}

	public static MetadataDto createMetadataFromPage(Page<?> page)
	{
		if(page==null)
			return null;
		
		MetadataDto metadataDto = new MetadataDto();
		
		PageDto pageDto = new PageDto();
		
		fillPageDto(pageDto,page);
		
		ElementsDto elementsDto = new ElementsDto();
		
		fillElementsDto(elementsDto,page);
		
		metadataDto.setPage(pageDto);
		metadataDto.setElements(elementsDto);
		
		metadataDto.setSort(page.getSort().stream().map(order->order.getProperty()+","+order.getDirection().name()).collect(Collectors.toList()));
		
		return metadataDto;
	}
}
