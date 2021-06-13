package me.erickzarat.portal.authchannels;

import org.springframework.data.repository.CrudRepository;

public interface AuthorizedChannelRepository extends CrudRepository<AuthorizedChannel, Integer> {
    Iterable<AuthorizedChannel> findAllByDealer_Code(Integer dealer);
}
