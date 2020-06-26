package com.aba.core.di.scope

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope


@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class PerFragment