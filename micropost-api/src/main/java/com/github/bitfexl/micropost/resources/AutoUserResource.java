package com.github.bitfexl.micropost.resources;

import com.github.bitfexl.micropost.entities.User;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

public interface AutoUserResource extends PanacheEntityResource<User, Long> {
}
