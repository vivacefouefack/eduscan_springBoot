package enetAfrica.eduScan.service;

import enetAfrica.eduScan.dto.PropectionRecordDto;
import enetAfrica.eduScan.model.ProspectionRecord;


public interface ProspectionRecordService {

    /**
     * Adds a new prospection record based on the provided data transfer object.
     *
     * @param prospectDto the data transfer object containing details for the new prospection record.
     * @return the added ProspectionRecord.
    */
    public ProspectionRecord addProspectionRecord(PropectionRecordDto prospectDto);

    /**
     * Updates an existing prospection record based on the provided data transfer object.
     *
     * @param prospectDto the data transfer object containing updated details for the prospection record.
     * @return the updated ProspectionRecord.
    */
    public ProspectionRecord updateProspectionRecord(PropectionRecordDto prospectDto);

    /**
     * Deletes a prospection record by its identifier.
     *
     * @param id the identifier of the prospection record to delete.
     */
    public void deleteProspectionRecord(Integer id);

    /**
     * Retrieves a prospection record by its identifier.
     *
     * @param id the identifier of the prospection record to retrieve.
     * @return the ProspectionRecord corresponding to the given identifier, if it exists.
    */
    public ProspectionRecord getProspectionRecordById(Integer id);

    /**
     * Retrieves all prospection records.
     *
     * @return an Iterable of all ProspectionRecord.
    */
    public Iterable<ProspectionRecord> getAllProspectionRecord();
}
