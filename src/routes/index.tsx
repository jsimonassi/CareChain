import React from 'react';
import {PreAuthStack} from './PreAuthRoutes';
import {PostAuthStack} from './PostAuthRoutes';
import {NavigationContainer} from '@react-navigation/native';
import {Loader} from '../components/Loader';
import {useMetaMask} from '../hooks/useMetamask';
import {BottomTab} from '../components/BottomTab';

export const CurrentStack = () => {
  const {walletAddress} = useMetaMask();

  console.log(walletAddress);

  if (walletAddress === null) {
    // return <Loader />;
    return <PostAuthStack />;
  }

  if (!walletAddress) {
    // return <PreAuthStack />;
    return <PostAuthStack />;
  }

  return <PostAuthStack />;
};

export const MainRouter = () => {
  return (
    <NavigationContainer>
      <CurrentStack />
      {/* <BottomTab /> */}
    </NavigationContainer>
  );
};
