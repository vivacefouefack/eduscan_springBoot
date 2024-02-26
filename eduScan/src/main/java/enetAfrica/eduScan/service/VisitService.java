package enetAfrica.eduScan.service;

import enetAfrica.eduScan.dto.VisitDto;
import enetAfrica.eduScan.model.Visit;

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
    public void deleteVisit(int id);

    /**
     * 
     * @param id
     * @return
     */
    public Visit getVisitById(int id);

    /**
     * 
     * @return
     */
    public Iterable<Visit> getAllVisit();


}
