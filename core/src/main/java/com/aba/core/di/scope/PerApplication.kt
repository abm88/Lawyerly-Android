package com.aba.core.di.scope


import java.lang.annotation.Retention
import javax.inject.Scope
import java.lang.annotation.RetentionPolicy.RUNTIME

@Scope
@Retention(RUNTIME)
annotation class PerApplication