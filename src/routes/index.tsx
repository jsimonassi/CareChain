import React from 'react';
import {PreAuthStack} from './PreAuthRoutes';
import {PostAuthStack} from './PostAuthRoutes';
import {NavigationContainer} from '@react-navigation/native';
import {Loader} from '../components/Loader';
import {useMetaMask} from '../hooks/useMetamask';

export const CurrentStack = () => {
  const {walletAddress} = useMetaMask();

  if (!walletAddress) {
    return <Loader />;
  }

  if (walletAddress === '') {
    return <PreAuthStack />;
  }

  return <PostAuthStack />;
};

export const MainRouter = () => {
  return (
    <NavigationContainer>
      <CurrentStack />
    </NavigationContainer>
  );
};
