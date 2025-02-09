package fr.gameon.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "games")
public class GameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "slug", unique = true, nullable = false)
    private String slug;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)
    private String releaseDate;

    @Column(name = "min_age")
    private Integer minAge;

    @Column(name = "min_players")
    private Integer minPlayers;

    @Column(name = "max_players")
    private Integer maxPlayers;

    @Column(name = "min_duration")
    private Integer minDuration;

    @Column(name = "max_duration")
    private Integer maxDuration;

    @Column(name = "ean")
    private String ean;

    @Column(name = "globalNote")
    private Double globalNote;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Game_Mechanism",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "mechanism_id")
    )
    private Set<MechanismEntity> mechanisms;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Game_Authors",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    @OrderBy("id ASC")
    private Set<AuthorEntity> authors = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Game_Illustrators",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "illustrator_id")
    )
    @OrderBy("id ASC")
    private Set<IllustratorEntity> illustrators = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id")
    @OrderBy("id ASC")
    private PublisherEntity publisher;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<GameImageEntity> imageUrls;

    @Column(name = "youtube_url")
    private String youtubeUrl;

    @Column(name = "bga_url")
    private String bgaUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(Integer minPlayers) {
        this.minPlayers = minPlayers;
    }

    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public Integer getMinDuration() {
        return minDuration;
    }

    public void setMinDuration(Integer minDuration) {
        this.minDuration = minDuration;
    }

    public Integer getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(Integer maxDuration) {
        this.maxDuration = maxDuration;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public Double getGlobalNote() {
        return globalNote;
    }

    public void setGlobalNote(Double globalNote) {
        this.globalNote = globalNote;
    }

    public Set<MechanismEntity> getMechanisms() {
        return mechanisms;
    }

    public void setMechanisms(Set<MechanismEntity> mechanisms) {
        this.mechanisms = mechanisms;
    }

    public Set<AuthorEntity> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorEntity> authors) {
        this.authors = authors;
    }

    public Set<IllustratorEntity> getIllustrators() {
        return illustrators;
    }

    public void setIllustrators(Set<IllustratorEntity> illustrators) {
        this.illustrators = illustrators;
    }

    public PublisherEntity getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherEntity publisher) {
        this.publisher = publisher;
    }

    public List<GameImageEntity> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<GameImageEntity> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }

    public String getBgaUrl() {
        return bgaUrl;
    }

    public void setBgaUrl(String bgaUrl) {
        this.bgaUrl = bgaUrl;
    }
}
