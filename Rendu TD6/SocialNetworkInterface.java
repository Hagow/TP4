package fr.unice.iut.info.reseauSocial.core;


import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

/**
 Interface "basique" de d�finition d'un r�seau social
 */

/**
 * @author blay
 *
 */
public interface SocialNetworkInterface extends Observer
{
    /**
     * @param identifier for a member
     * @return member if known by the network
     */
    MemberInterface getMember (String identifier);
    
    /**
     * @return the set of members belonging to the network
     */
    Collection<? extends MemberInterface> getMembers ();
    
    /**
     * @param identifier
     * @param age
     * @param description
     * @return created Member (it has been added to the network)
     */
    MemberInterface addMember (String identifier, int age, String description);
    
    /**
     * @param ident
     * @param belongsToAnotherNetwork does the member to be created belong to another network?
     *  if it is, a link must be created with the other network.
     */
    
    /**
     *
     * Add the relationship between a member and a friend with a given force.
     *
     * @param force
     * @param member
     * @param friend
     *
     */
    void relate (int force, MemberInterface member, MemberInterface friend);
    
    /**
     * @param member
     * @param rank
     * @return returns all members given the rank (at rank 1 : direct neighbors; at rank 2 :  neighbors of neighbors.
     * A member appears at the lowest rank, it does not appear in a higher rank
     */
    Collection<? extends MemberInterface> relateToRank (MemberInterface member, int rank);
    
    /**
     * @param member1
     * @param member2
     * @return distance between the two members
     */
    int distance (MemberInterface member1, MemberInterface member2);
    
    /**
     * Set the secondary network to which you can connect.
     * @param o
     */
    void addOtherNetwork (Observable o);
}
