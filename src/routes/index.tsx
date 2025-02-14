import React from 'react';
import {PreAuthStack} from './PreAuthRoutes';
import {PostAuthStack} from './PostAuthRoutes';
import {NavigationContainer} from '@react-navigation/native';
import {Loader} from '../components/Loader';
import {useMetaMask} from '../hooks/useMetamask';

export const CurrentStack = () => {
  const {walletAddress} = useMetaMask();

  console.log(walletAddress);

  if (walletAddress === null) {
    return <Loader />;
  }

  if (!walletAddress) {
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
