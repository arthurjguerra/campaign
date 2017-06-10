package service;

import core.Campaign;

import java.util.Date;
import java.util.List;

/**
 * Campaign service.
 */
public interface CampaignService {

    /**
     * Creates a new campaign.
     * @param id id of the campaign
     * @param teamId favorite team's id
     * @param dateStart date when the campaign starts
     * @param dateEnd date when the campaign ends
     * @return @{@link Campaign} object just created
     */
    Campaign create(int id, int teamId, Date dateStart, Date dateEnd);

    /**
     * Finds all existing campaigns that are still valid. Campaigns already expired
     * are not listed here.
     * @return List of valid campaigns
     */
    List<Campaign> findAll();
}
