package com.dbms.services;

import com.dbms.domain.ActressGenreMovie;
import com.dbms.domain.DashBoard;
import com.dbms.domain.UserMovie;
import com.dbms.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mengleisun on 4/18/16.
 */
@Service
public class DashBoardServiceImpl implements DashBoardService{
    private ActorGenreMovieRepository actorGenreMovieRepository;
    private ActorRepository actorRepository;
    private ActressGenreMovieRepository actressGenreMovieRepository;
    private ActressRepository actressRepository;
    private CompanyRepository companyRepository;
    private DiscriptionRepository discriptionRepository;
    private FriendRepository friendRepository;
    private LikeMovieRepository likeMovieRepository;
    private MovieRepository movieRepository;
    private PicturesRepository picturesRepository;
    private RatingRepository ratingRepository;
    private UserActorRepository userActorRepository;
    private UserActressRepository userActressRepository;
    private UserMovieRepository userMovieRepository;
    private UsersRepository usersRepository;
    @Autowired
    public void setUserActorRepository(UserActorRepository userActorRepository) {
        this.userActorRepository = userActorRepository;
    }
    @Autowired
    public void setUserActressRepository(UserActressRepository userActressRepository) {
        this.userActressRepository = userActressRepository;
    }
    @Autowired
    public void setUserMovieRepository(UserMovieRepository userMovieRepository) {
        this.userMovieRepository = userMovieRepository;
    }
    @Autowired
    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    @Autowired
    public void setActorGenreMovieRepository(ActorGenreMovieRepository actorGenreMovieRepository) {
        this.actorGenreMovieRepository = actorGenreMovieRepository;
    }
    @Autowired
    public void setActorRepository(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }
    @Autowired
    public void setActressGenreMovieRepository(ActressGenreMovieRepository actressGenreMovieRepository) {
        this.actressGenreMovieRepository = actressGenreMovieRepository;
    }
    @Autowired
    public void setActressRepository(ActressRepository actressRepository) {
        this.actressRepository = actressRepository;
    }
    @Autowired
    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    @Autowired
    public void setDiscriptionRepository(DiscriptionRepository discriptionRepository) {
        this.discriptionRepository = discriptionRepository;
    }
    @Autowired
    public void setFriendRepository(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }
    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Autowired
    public void setPicturesRepository(PicturesRepository picturesRepository) {
        this.picturesRepository = picturesRepository;
    }
    @Autowired
    public void setRatingRepository(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }
    @Autowired
    public void setLikeMovieRepository(LikeMovieRepository likeMovieRepository) {
        this.likeMovieRepository = likeMovieRepository;
    }
    @Override
    public DashBoard displayTotal() {
        DashBoard dashBoard = new DashBoard();
        dashBoard.actorGenreMovieNumber = actorGenreMovieRepository.findTotal();
        dashBoard.actorNumber = actorRepository.findTotal();
        dashBoard.actressGenreMovieNumber = actressGenreMovieRepository.findTotal();
        dashBoard.actressNumber = actressRepository.findTotal();
        dashBoard.companyNumber = companyRepository.findTotal();
        dashBoard.discriptionNumber = discriptionRepository.findTotal();
        dashBoard.friendNumber = friendRepository.findTotal();
        dashBoard.likeMovieNumber = likeMovieRepository.findTotal();
        dashBoard.movieNumber = movieRepository.findTotal();
        dashBoard.picturesNumber = picturesRepository.findTotal();
        dashBoard.ratingNumber = ratingRepository.findTotal();
        dashBoard.userActorNumber = userActorRepository.findTotal();
        dashBoard.userActressNumber = userActressRepository.findTotal();
        dashBoard.userMovieNumber = userMovieRepository.findTotal();
        dashBoard.usersNumber = usersRepository.findTotal();
        return dashBoard;
    }

}
