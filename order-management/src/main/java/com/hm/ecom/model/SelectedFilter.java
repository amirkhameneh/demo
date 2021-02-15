package com.hm.ecom.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class SelectedFilter {
	Long srl;
	Long value;
	String text;
	Range range;
	List<Value> values;
}
