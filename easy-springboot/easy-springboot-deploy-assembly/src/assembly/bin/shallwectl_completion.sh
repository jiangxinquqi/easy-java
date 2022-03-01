#!/usr/bin/env bash

_shallwectl(){
	COMPREPLY=()
	local cur services
	cur=${COMP_WORDS[COMP_CWORD]}
	services="service1 service2"
	if [[ $COMP_CWORD -eq 1 ]]; then
		COMPREPLY=($(compgen -W "start stop restart status" -- ${cur}))
	elif [[ $COMP_CWORD -eq 2 ]]; then
		COMPREPLY=($(compgen -W "${services}" -- ${cur}))
	fi
}
