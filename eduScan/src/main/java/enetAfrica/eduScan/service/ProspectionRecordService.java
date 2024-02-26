package enetAfrica.eduScan.service;

import enetAfrica.eduScan.dto.PropectionRecordDto;
import enetAfrica.eduScan.model.ProspectionRecord;


public interface ProspectionRecordService {

    /**
     * Permet d'ajouter un nouveau fichier de prospection.
     * @param prospectionRecord le nouveau fichier de prospection à ajouter.
     * @return le fichier de prospection ajouté.
     */
    public ProspectionRecord addProspectionRecord(PropectionRecordDto prospectDto);

    /**
     * Permet de modifier un fichier de prospection existant.
     * @param prospectionRecord le fichier de prospection avec les modifications à apporter.
     * @return le fichier de prospection modifié.
     */
    public ProspectionRecord updateProspectionRecord(PropectionRecordDto prospectDto);

    /**
     * Permet de supprimer un fichier de prospection à travers son identifiant.
     * @param id l'identifiant du fichier de prospection à supprimer.
     */
    public void deleteProspectionRecord(int id);

    /**
     * Permet d'obtenir un fichier de prospection à travers son identifiant.
     * @param id l'identifiant du fichier de prospection à obtenir.
     * @return le fichier de prospection correspondant à l'identifiant donné, s'il existe.
     */
    public ProspectionRecord getProspectionRecordById(int id);


    /**
     * permet d'obtenir tous les fichiers de prospection.
     * @return liste de tous les fichiers de prospetion.
     */
    public Iterable<ProspectionRecord> getAllProspectionRecord();
}
