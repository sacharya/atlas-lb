package org.openstack.atlas.service.domain.repository;

import org.openstack.atlas.service.domain.entity.LoadBalancer;
import org.openstack.atlas.service.domain.entity.LoadBalancerJoinVip;
import org.openstack.atlas.service.domain.entity.LoadBalancerStatus;
import org.openstack.atlas.service.domain.exception.EntityNotFoundException;
import org.openstack.atlas.service.domain.exception.UnprocessableEntityException;

import java.util.List;
import java.util.Set;

public interface LoadBalancerRepository {
    LoadBalancer getById(Integer id) throws EntityNotFoundException;

    List<LoadBalancer> getByAccountId(Integer accountId);

    LoadBalancer getByIdAndAccountId(Integer id, Integer accountId) throws EntityNotFoundException;

    LoadBalancer create(LoadBalancer loadBalancer);

    LoadBalancer update(LoadBalancer loadBalancer);

    Integer getNumNonDeletedLoadBalancersForAccount(Integer accountId);

    void changeStatus(Integer accountId, Integer loadbalancerId, LoadBalancerStatus newStatus, boolean allowConcurrentModifications) throws EntityNotFoundException, UnprocessableEntityException;

    void changeStatus(Integer accountId, Integer loadbalancerId, LoadBalancerStatus newStatus) throws EntityNotFoundException, UnprocessableEntityException;

    void updatePortInJoinTable(LoadBalancer lb);

    boolean canUpdateToNewPort(Integer newPort, Set<LoadBalancerJoinVip> setToCheckAgainst);

    LoadBalancer changeStatus(LoadBalancer loadBalancer, LoadBalancerStatus status) throws EntityNotFoundException;

}
