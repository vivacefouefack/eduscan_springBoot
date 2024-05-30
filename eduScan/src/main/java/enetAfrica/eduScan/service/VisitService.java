package enetAfrica.eduScan.service;

import enetAfrica.eduScan.dto.VisitDto;
import enetAfrica.eduScan.model.Visit;
import jakarta.validation.Valid;

public interface VisitService {

    /**
     * 
     * @param visitDto
     * @return
     */
    public Visit addVisit(VisitDto visitDto);

    /**
     * 
     * @param visitDto
     * @return
     */
    public Visit updateVisit(VisitDto visitDto);

    /**
     * 
     * @param id
     */
    public void deleteVisit(Integer id);

    /**
     * 
     * @param id
     * @return
     */
    public Iterable<Visit> getVisitById(Integer id);

    /**
     * 
     * @return
     */
    public Iterable<Visit> getAllVisit();

    public Visit valideVisitById(@Valid int id);

    public Visit valide(@Valid int id);


}
