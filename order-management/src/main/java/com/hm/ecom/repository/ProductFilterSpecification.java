package com.hm.ecom.repository;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.hm.ecom.model.ProductFilter;
import com.hm.ecom.model.SelectedFilter;

public class ProductFilterSpecification implements Specification<ProductFilter> {
    private final long domain;
    private final long category;
    private final long center;
    private final SelectedFilter selectedFilter;
    private final List<Long> products;
    //private final long campaign;
    /*private final List<Long> products;
    private final long filter;
    private final long val;
    private final String text;
    private final List<Long> values ;*/
    //private final List<SelectedFilter> selectedFilter;

    public ProductFilterSpecification(long domain,long category,long center/*,Long campaign,List<SelectedFilter> selectedFilter*/
    		,List<Long> products ,SelectedFilter selectedFilter ) {
        this.domain = domain;
        this.category = category;
        this.center = center;
        this.selectedFilter = selectedFilter;
       // this.campaign = campaign;
        /*this.filter = filter;
        this.val = val;
        this.text = text;
        this.values = values;*/
        this.products = products;
                
        //this.selectedFilter = selectedFilter;
    }

    @Override
    public Predicate toPredicate(Root<ProductFilter> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
    	List<Predicate> predicates = new LinkedList<>();

    	//predicates.add(cb.equal(root.get("domain"), domain));
    	

    	
    	//predicates.add(cb.equal(root.get("domain"), domain));
    	//if (category!=-1) {
    		predicates.add(cb.equal(root.get("type"), 1));
    		predicates.add(cb.equal(root.get("value"), category));
        	/*Predicate predicate1 = cb.equal(root.get("type"), 1);
        	Predicate predicate2 = cb.equal(root.get("value"), category);*/
    	//}/*else {
    		/*predicates.add(cb.equal(root.get("filter"), selectedFilter.getSrl()));
    		if (Long.valueOf(selectedFilter.getValue()) != null)  {
    			predicates.add(cb.equal(root.get("value"), selectedFilter.getValue()));	
    		} else if (selectedFilter.getText() != null){
    			predicates.add(cb.like(root.get("text"), "%" + selectedFilter.getText() + "%"));
    		}	
    		/* else if (values != null){
    			 predicates.add(cb.equal(root.get("value"), values.get(0)));	
    			}*/
    		//}
    	
    	
    	
    	
    	
    	/*Predicate predicate0 = cb.equal(root.get("domain"), domain);
    	if (category!=-1) {
        	Predicate predicate1 = cb.equal(root.get("type"), 1);
        	Predicate predicate2 = cb.equal(root.get("value"), category);
        	
    	}*/
    	
    	
    	//predicates.add(cb.equal(root.get("product"), dd));
    	//predicates.add(cb.like(root.<String>get("name"), "%" + searchKey.trim() + "%"));


    	
    	//return cb.and(predicate0,predicate1,predicate2 );
    			//cb.and(predicate1 , predicate2);
    	 return cb.and(predicates.toArray(new Predicate[]{}));
    }
}
