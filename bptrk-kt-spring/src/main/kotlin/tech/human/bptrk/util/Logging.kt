package tech.human.bptrk.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory.getLogger

interface Logging

fun <T : Logging> T.logger(): Logger = getLogger(javaClass)