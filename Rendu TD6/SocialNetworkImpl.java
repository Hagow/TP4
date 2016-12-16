package fr.unice.iut.info.reseauSocial.implementation2016;

import fr.unice.iut.info.facebookGhost.FacebookGhostNetwork;
import fr.unice.iut.info.facebookGhost.RelationEvent;
import fr.unice.iut.info.facebookGhost.User;
import fr.unice.iut.info.facebookGhost.UserEvent;
import fr.unice.iut.info.grapheSimple.GrapheSimple;
import fr.unice.iut.info.grapheSimple.ParcoursSimple;
import fr.unice.iut.info.grapheX.Sommet;
import fr.unice.iut.info.reseauSocial.core.MemberInterface;
import fr.unice.iut.info.reseauSocial.core.SocialNetworkInterface;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;

public class SocialNetworkImpl implements SocialNetworkInterface
{
    private GrapheSimple grapheSimple = new GrapheSimple();
    private String name;
    
    public SocialNetworkImpl (String newName)
    {
        name = newName;
    }
    
    @Override
    public MemberInterface getMember (String identifier)
    {
        for (Sommet sommet : grapheSimple.sommets())
        {
            if(sommet.identifiant().equals(identifier)) return (MemberInterface) sommet;
        }
        
        return null;
    }
    
    @Override
    public Collection<? extends MemberInterface> getMembers ()
    {
        ArrayList<MemberInterface> listMembers = new ArrayList<>();
        
        for (Sommet sommet : grapheSimple.sommets())
        {
            listMembers.add((MemberInterface) sommet);
        }
        
        return listMembers;
    }
    
    @Override
    public MemberInterface addMember (String identifier, int age, String description)
    {
        MemberImpl member = new MemberImpl(identifier, age, description);
        grapheSimple.ajouterSommet(member);
        return member;
    }
    
    @Override
    public void relate (int force, MemberInterface member, MemberInterface friend)
    {
        Sommet sommet1 = grapheSimple.getSommet(member.ident());
        Sommet sommet2 = grapheSimple.getSommet(friend.ident());
        
        grapheSimple.ajouterArc(sommet1, sommet2, force);
        grapheSimple.ajouterArc(sommet2, sommet1, force);
    }
    
    @Override
    public Collection<? extends MemberInterface> relateToRank (MemberInterface member, int rank)
    {
        ParcoursSimple parcoursSimple = new ParcoursSimple(grapheSimple);
        Sommet sommet1 = grapheSimple.getSommet(member.ident());
        
        
        ArrayList<MemberInterface> listMembers = new ArrayList<>();
        
        for (Sommet s : parcoursSimple.voisinsAuRang(sommet1, rank))
        {
            listMembers.add((MemberInterface) s);
        }
        
        return listMembers;
    }
    
    @Override
    public int distance (MemberInterface member1, MemberInterface member2)
    {
        ParcoursSimple parcoursSimple = new ParcoursSimple(grapheSimple);
        Sommet sommet1 = grapheSimple.getSommet(member1.ident());
        Sommet sommet2 = grapheSimple.getSommet(member2.ident());
        
        return (parcoursSimple.cheminLePlusCourt(sommet1, sommet2)).distance();
    }
    
    @Override
    public void addOtherNetwork (Observable o)
    {
        o.addObserver(this);
        
        if(o instanceof FacebookGhostNetwork)
        {
            FacebookGhostNetwork fg = (FacebookGhostNetwork) o;
            
            for (User u : fg.getAllUsers())
            {
                grapheSimple.ajouterSommet(new MemberImplUser(u));
            }
            
            for (User u1 : fg.getAllUsers())
            {
                for (User u2 : u1.getFamily())
                {
                    grapheSimple.ajouterArc(new MemberImplUser(u1), new MemberImplUser(u2), 1);
                }
                
                for (User u3 : u1.getFamily())
                {
                    grapheSimple.ajouterArc(new MemberImplUser(u1), new MemberImplUser(u3), 2);
                }
            }
        }
    }
    
    @Override
    public void update (Observable observable, Object arg)
    {
        if(observable instanceof FacebookGhostNetwork)
        {
            Platform.runLater(new Runnable()
            {
                public void run ()
                {
                    RelationEvent relationEvent;
                    UserEvent userEvent;
                    
                    if(arg instanceof RelationEvent)
                    {
                        relationEvent = (RelationEvent) arg;
                        
                        MemberImplUser member1 = new MemberImplUser(relationEvent.getU1());
                        MemberImplUser member2 = new MemberImplUser(relationEvent.getU2());
                        int rank = relationEvent.getNature().equals("Family") ? 1 : 2;
                        
                        grapheSimple.ajouterArc(member1, member2, rank);
                    }
                    
                    else
                    {
                        userEvent = (UserEvent) arg;
                        
                        MemberImplUser member = new MemberImplUser(userEvent.getAddedUser());
                        
                        grapheSimple.ajouterSommet(member);
                    }
                }
            });
        }
    }
}
